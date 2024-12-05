function* fibGenerator(): Generator<number, any, number> {
    let current = 0;
    let next = 1;

    while (true) {
        yield current;
        
        let tmp = current;
        current = next;
        next = tmp + next;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
