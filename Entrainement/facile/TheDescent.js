// game loop
while (true) {
    let maxHeight = 0
    let indexOfMaxHeight = 0
    for (let i = 0; i < 8; i++) {
        const mountainH = parseInt(readline()); // represents the height of one mountain.
        if (mountainH > maxHeight){
            maxHeight = mountainH
            indexOfMaxHeight = i
        }
    }
    console.log(indexOfMaxHeight);     // The index of the mountain to fire on.
}
