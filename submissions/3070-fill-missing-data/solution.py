import pandas as pd
import numpy as np

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    products["quantity"].fillna(0, inplace=True)
    return products
