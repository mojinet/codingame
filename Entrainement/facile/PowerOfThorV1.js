var inputs = readline().split(' ');
const lightX = parseInt(inputs[0]); // the X position of the light of power
const lightY = parseInt(inputs[1]); // the Y position of the light of power
const initialTx = parseInt(inputs[2]); // Thor's starting X position
const initialTy = parseInt(inputs[3]); // Thor's starting Y position
let currentPosTx = initialTx
let currentPosTy = initialTy

// game loop
while (true) {
    const remainingTurns = parseInt(readline()); // The remaining amount of turns Thor can move. Do not remove this line.

    let res = ""
    // N/S
    if(lightY < currentPosTy){
        res += "N"
        currentPosTy--
    }else if(lightY > currentPosTy){
        res += "S"
        currentPosTy++
    }

    // E/W
    if(lightX > currentPosTx){
        res += "E"
        currentPosTx++
    }else if(lightX < currentPosTx){
        res += "W"
        currentPosTx--
    }

    // A single line providing the move to be made: N NE E SE S SW W or NW
    console.log(res);
}
