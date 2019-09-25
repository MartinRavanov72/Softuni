function timer() {
            let startBtn = $('#start-timer');
            let stopBtn = $('#stop-timer');
            let tickLoop;
            let seconds = 0;
            let timerSeconds = $('#seconds');
            let timerMinutes = $('#minutes');
            let timerHours = $('#hours');
            let started = false;
            startBtn.on('click', startLoop);
            stopBtn.on('click', pauseLoop);

            function startLoop() {
                if (!started) {
                    tickLoop = setInterval(tick, 1000);
                    started = true;
                }
            }

            function pauseLoop() {
                clearInterval(tickLoop);
                started = false;
            }

            function tick() {
                seconds++;
                timerSeconds.text(("0" + seconds % 60).slice(-2));
                timerMinutes.text(("0" + Math.floor(seconds / 60 % 60)).slice(-2));
                timerHours.text(("0" + Math.floor(seconds / 3600)).slice(-2));
            }
        }