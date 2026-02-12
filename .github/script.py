import os
import subprocess
import re

def get_runtime_memory(submission):
    """
    Extract runtime and memory usage from the commit message of the most recent commit
    affecting the given submission directory.
    """
    try:
        commit_msg = subprocess.check_output(
            ["git", "log", "-1", "--pretty=%B", f"submissions/{submission}"], 
            text=True
        ).strip()

        runtime_match = re.search(r"Runtime - ([\d]+ ms)", commit_msg)
        memory_match = re.search(r"Memory - ([\d]+?(MB|B))", commit_msg)

        runtime = runtime_match.group(1) if runtime_match else "N/A"
        memory = memory_match.group(1) if memory_match else "N/A"

        return runtime, memory
    except subprocess.CalledProcessError:
        return "N/A", "N/A"

def generate_readme(submissions_dir, output_file):
    header = "| #   | Title                                      | Runtime   | Memory    |\n|-----|--------------------------------------------|-----------|-----------|\n"
    rows = []

    # Ensure submissions directory exists to avoid crashing when empty/missing
    if not os.path.exists(submissions_dir):
        os.makedirs(submissions_dir, exist_ok=True)

    for entry in os.listdir(submissions_dir):
        path = os.path.join(submissions_dir, entry)
        if os.path.isdir(path) and '-' in entry:
            number, title = entry.split('-', 1)

            display_title = title.replace('-', ' ').title()
            problem_url = f"https://leetcode.com/problems/{title}/"

            runtime, memory = get_runtime_memory(entry)
            
            rows.append(f"| {number} | [{display_title}]({problem_url}) | {runtime} | {memory} |")

    rows.sort()
    with open(output_file, "w") as f:
        f.write("# Submissions\n\n")
        f.write(header)
        f.write("\n".join(rows))

if __name__ == "__main__":
    submissions_dir = "./submissions"
    output_file = "./README.md"
    generate_readme(submissions_dir, output_file)
