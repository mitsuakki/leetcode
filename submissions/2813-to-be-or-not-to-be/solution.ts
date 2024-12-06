type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
    return {
        toBe: function(other: any) {
            if (val === other) {
                return true;
            } else {
                throw new Error("Not Equal")
            }
        },

        notToBe: function(other: any) {
            if (val !== other) {
                return true;
            } else {
                throw new Error("Equal")
            }
        },
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
