#!/usr/bin/env bash
set -euo pipefail

# Usage: prune_submissions.sh [preferred_langs]
# preferred_langs: comma-separated list of extensions (e.g. rs,cpp,py,java)

pref_input="${1:-${PREFERRED_LANGS:-rs,cpp,py,java}}"
IFS=',' read -ra prefs <<< "$pref_input"

shopt -s nullglob
for dir in submissions/*; do
  [ -d "$dir" ] || continue
  files=("$dir"/*.{java,py,cpp,rs,c,cc,cxx,ts,js,sql,m})
  files=("${files[@]}")
  if [ ${#files[@]} -le 1 ]; then
    continue
  fi

  chosen=""
  for p in "${prefs[@]}"; do
    case "$p" in
      cpp) exts=(cpp cc cxx);;
      c) exts=(c);;
      rs) exts=(rs);;
      py) exts=(py);;
      java) exts=(java);;
      ts) exts=(ts);;
      js) exts=(js);;
      sql) exts=(sql);;
      m) exts=(m);;
      *) exts=("$p");;
    esac

    candidates=()
    for e in "${exts[@]}"; do
      for f in "$dir"/*."$e"; do
        [ -e "$f" ] && candidates+=("$f")
      done
    done

    if [ ${#candidates[@]} -gt 0 ]; then
      chosen=$(ls -t "${candidates[@]}" 2>/dev/null | head -n 1) || true
      break
    fi
  done

  if [ -z "$chosen" ]; then
    chosen=$(ls -t "${files[@]}" 2>/dev/null | head -n 1) || true
  fi

  for f in "${files[@]}"; do
    if [ "$f" != "$chosen" ]; then
      rm -f "$f"
    fi
  done
done
