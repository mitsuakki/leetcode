type Fn = (n: number, i: number) => any

function filter(arr: number[], fn: Fn): number[] {
    return arr.flatMap((i, j) => fn (i, j) ? [i] : []);
};
