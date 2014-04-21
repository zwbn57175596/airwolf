var loghl = "<style type=text/css'> " +
    "   html {  font-family: Helvetica;  color: #222;  } \
        h1 {color: steelblue; font-size: 24px; margin-top: 24px; } \
        button { margin: 0 3px 10px;  font-size: 12px;  } \
        .logLine { border-bottom: 1px solid #ccc; padding: 4px 2px;  font-family: courier;  \
        font-size: 11px; } </style> \
        <div id='log'></div>";
var div = document.createElement("div");
div.id = "log";
document.body.appendChild(div);
var style = document.createElement("style"); 
style.type = "text/css"; 
style.appendChild( document.createTextNode( loghl ) ); 
var head = document.getElementsByTagName("head")[0]; 
head.appendChild(style);

var uniqueId = 1;
function log(message, data) {
  var log = document.getElementById('log');
  var el = document.createElement('div');
  el.className = 'logLine';
  el.innerHTML = uniqueId++ + '. ' + message + (data ? ':<br/>' + JSON.stringify(data) : '');
  if (log.children.length) {
    log.insertBefore(el, log.children[0]);
  } else {
    log.appendChild(el);
  }
}

window.onerror = function(err) {
  log('window.onerror: ' + err);
};
