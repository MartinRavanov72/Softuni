function browserLogger(browserInfo, actions) {
    let openTabs = browserInfo["Open Tabs"];
    let closedTabs = browserInfo["Recently Closed"];
    let logs = browserInfo["Browser Logs"];
    let browserName = browserInfo["Browser Name"];
    for (let action of actions) {
        if (action.startsWith("Open")) {
            let siteName = action.substr(5);
            openTabs.push(siteName);
            logs.push(action);
        } else if (action.startsWith("Close")) {
            let siteName = action.substr(6);
            if (openTabs.includes(siteName)) {
                closedTabs.push(siteName);
                openTabs.splice(openTabs.indexOf(siteName), 1);
                logs.push(action);
            }
        } else {
            [openTabs, closedTabs, logs] = [[], [], []];
        }
    }
    console.log(browserName);
    console.log("Open Tabs: %s", openTabs.join(", "));
    console.log("Recently Closed: %s", closedTabs.join(", "));
    console.log("Browser Logs: %s", logs.join(", "));
}