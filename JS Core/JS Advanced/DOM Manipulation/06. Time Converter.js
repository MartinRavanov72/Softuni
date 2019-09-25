function attachEventsListeners() {
    document.getElementById('daysBtn').addEventListener('click', onClickDays);
    document.getElementById('hoursBtn').addEventListener('click', onClickHours);
    document.getElementById('minutesBtn').addEventListener('click', onClickMinutes);
    document.getElementById('secondsBtn').addEventListener('click', onClickSeconds);

    let days = document.getElementById('days');
    let hours = document.getElementById('hours');
    let minutes = document.getElementById('minutes');
    let seconds = document.getElementById('seconds');

    function onClickDays() {
        hours.value = +days.value * 24;
        minutes.value = +hours.value * 60;
        seconds.value = +minutes.value * 60;
    }

    function onClickHours() {
        days.value = +hours.value / 24;
        minutes.value = +hours.value * 60;
        seconds.value = +minutes.value * 60;
    }

    function onClickMinutes() {
        hours.value = +minutes.value / 60;
        days.value = +hours.value/ 24;
        seconds.value = +minutes.value * 60;
    }

    function onClickSeconds() {
        minutes.value = +seconds.value / 60;
        hours.value = +minutes.value / 60;
        days.value = +hours.value / 24;
    }
}