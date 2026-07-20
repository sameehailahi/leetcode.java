var checkIfInstanceOf = function(obj, classFunction) {

    // null and undefined are not instances
    if (obj === null || obj === undefined) {
        return false;
    }

    let current = obj;

    // Iterate through prototype chain
    while (current !== null) {

        if (current.constructor === classFunction) {
            return true;
        }

        current = Object.getPrototypeOf(current);
    }

    return false;
};