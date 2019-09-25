function attachEvents() {
  const baseURL = `https://baas.kinvey.com/appdata/kid_Sk-IL55Am`;
  const base64auth = btoa(`m.ravanov@gmail.com:nqmadakaja`);
  const authHeader = {
    'Authorization': 'Basic ' + base64auth,
    'Content-type': 'application/json'
  };


  $('.load').on('click', loadCatches);
  $('.add').on('click', addCatch);

  function req(method, endpoint, data) {
    return $.ajax({
      method: method,
      url: baseURL + endpoint,
      headers: authHeader,
      data: JSON.stringify(data)
    });
  }


  async function loadCatches() {
    let data = await req('GET', '/biggestCatches').catch(error => handleError(error));
    displayAllCatches(data);
  }

  function displayAllCatches(data) {
    let catches = $('#catches');
    catches.empty();
    for (let el of data) {
      catches.append($(`<div class="catch" data-id="${el._id}">`)
        .append($('<label>')
          .text('Angler'))
        .append($(`<input type="text" class="angler" value="${el['angler']}"/>`))
        .append($('<label>')
          .text('Weight'))
        .append($(`<input type="number" class="weight" value="${el['weight']}"/>`))
        .append($('<label>')
          .text('Species'))
        .append($(`<input type="text" class="species" value="${el['species']}"/>`))
        .append($('<label>')
          .text('Location'))
        .append($(`<input type="text" class="location" value="${el['location']}"/>`))
        .append($('<label>')
          .text('Bait'))
        .append($(`<input type="text" class="bait" value="${el['bait']}"/>`))
        .append($('<label>')
          .text('Capture Time'))
        .append($(`<input type="number" class="captureTime" value="${el['captureTime']}"/>`))
        .append($(`<button class="update">Update</button>`).on('click', updateCatch))
        .append($(`<button class="delete">Delete</button>`).on('click', deleteCatch))
      );
    }
  }

  async function addCatch() {
    let catchEl = $('#addForm');
    let dataObj = createDataJSON(catchEl);
    let a = req('POST', '/biggestCatches', dataObj).catch(error => handleError(error))
  }

  function updateCatch() {
    let catchEl = $(this).parent();
    let dataObj = createDataJSON(catchEl);

    let a = req('PUT', `/biggestCatches/${catchEl.attr('data-id')}`, dataObj).catch(error => handleError(error));
  }

  function deleteCatch() {
    let catchEl = $(this).parent();

    let a = req('DELETE', `/biggestCatches/${catchEl.attr('data-id')}`).catch(error => handleError(error));
  }

  function createDataJSON(catchEl) {
    return {
      captureTime: Number(catchEl.find('.captureTime').val()),
      bait: catchEl.find('.bait').val(),
      location: catchEl.find('.location').val(),
      species: catchEl.find('.species').val(),
      weight: Number(catchEl.find('.weight').val()),
      angler: catchEl.find('.angler').val(),
    };
  }

  function handleError(err) {
    console.warn(err.statusText);
  }
}