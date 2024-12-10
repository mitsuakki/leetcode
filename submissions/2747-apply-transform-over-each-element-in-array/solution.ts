function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    const resultArr = [];

    for (let i = 0; i < arr.length; i++) {
        resultArr[i] = fn(arr[i], i);
    }

    return resultArr;
};
