import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

var apps = <App />;
ReactDOM.render(apps, document.getElementById('root'));
registerServiceWorker();
