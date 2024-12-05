import pandas as pd

def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    return pd.DataFrame(animals[animals["weight"] > 100].sort_values(by="weight", ascending=False)["name"])

