const n = parseInt(readline()); // the number of temperatures to analyse
var inputs = readline().split(' ');

// set the max +1
let temperatureNearZero = 5527 
for (let i = 0; i < n; i++) {
    const t = parseInt(inputs[i]);// a temperature expressed as an integer ranging from -273 to 5526

    // compare absolute values, if it's the same absolute value, we keep the higher temperature 
    if(Math.abs(t) < Math.abs(temperatureNearZero)){
        temperatureNearZero = t
    }else if(Math.abs(t) === Math.abs(temperatureNearZero)){
        temperatureNearZero = t < temperatureNearZero ? temperatureNearZero : t
    }
}

// if temperature isn't provided, send 0
console.log(temperatureNearZero === 5527 ? 0 : temperatureNearZero);
