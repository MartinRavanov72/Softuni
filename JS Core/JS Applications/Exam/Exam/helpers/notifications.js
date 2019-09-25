// Handle notifications
$(document).on({
    ajaxStart: () => $("#loadingBox").show(),
    ajaxStop: () => $('#loadingBox').fadeOut()
});

$('#infoBox').click(function () {
    $(this).hide();
});

$('#errorBox').click(function () {
    $(this).hide();
});

function showInfo(message) {
    let infoBox = $($('#infoBox span')[0]);
    infoBox.text(message);
    $('#infoBox').show();
    setTimeout(() => $('#infoBox').fadeOut(), 3000);
}

function showError(message) {
    let errorBox = $($('#errorBox span')[0]);
    errorBox.text(message);
    $('#errorBox').show();
}

function handleError(reason) {
    showError(reason.responseJSON.description);
}