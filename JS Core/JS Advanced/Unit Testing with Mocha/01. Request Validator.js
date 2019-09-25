function validateRequest(obj) {
  let method = obj.method;
  let uri = obj.uri;
  let version = obj.version;
  let message = obj.message;
  let properties = {
    method: false,
    uri: false,
    version: false,
    message: false
  };

  for (let prop in obj) {
    properties[prop] = true;
  }
  for (let prop in properties) {
    if (properties[prop] === false) {
      if (prop.toString() !== 'uri') {
        throw new Error(`Invalid request header: Invalid ${prop.toString().charAt(0).toUpperCase() + prop.toString().slice(1)}`);
      } else {
        throw new Error(`Invalid request header: Invalid ${prop.toString().toUpperCase()}`);
      }
    }
  }

  if (method !== 'GET' && method !== 'POST' && method !== 'DELETE' && method !== 'CONNECT') {
    throw new Error('Invalid request header: Invalid Method');
  }

  let uriRegex = /(^[A-Za-z0-9\.]+$)|(^\*$)/g;
  if (!uriRegex.test(uri) || uri === '') {
    throw new Error(`Invalid request header: Invalid URI`);
  }

  if (version !== 'HTTP/0.9' && version !== 'HTTP/1.0' && version !== 'HTTP/1.1' && version !== 'HTTP/2.0') {
    throw new Error(`Invalid request header: Invalid Version`);
  }

  let messageRegex = /^[^<>\\&'"]*$/g;
  if (!messageRegex.test(message)) {
    throw new Error(`Invalid request header: Invalid Message`);
  }
  return obj;
}