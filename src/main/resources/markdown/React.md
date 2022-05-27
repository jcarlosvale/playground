#REACT

## Links

* [REACT](https://reactjs.org/)

* [AXIOS](https://github.com/axios/axios)
  * npm install axios

* [ROUTER](https://v5.reactrouter.com/web/guides/quick-start)
  * npm install react-router-dom

## Concepts

* SPA - Single Page Applications
* JSX - html inside JS
* _fragment_ - tag empty

## First project

```
npx create-react-app <app-name>
```

* inside the project

```
npm start
```

## Properties

* sintaxe to inject

```javascript
  <App message="Ola" user="Bob"/>
```

* usage
```javascript
function App(props) {
  return (
    <>
      <h1>{props.message} {props.user}</h1>
    </>
  );
}
```

## States

* hook _useState_
* returns two elements: [state, setState]

```javascript
import React, { useState } from 'react';

function App(props) {
  const[user, setUser] = useState('BOB');
  return (
    <>
      <h1>Hello {user}</h1>
    </>
  );
}
```

## Controlled Components

* Uses the state of React Component as source of truth.
```javascript
const [user, setUser] = useState("");

...

<input className='usuarioInput' placeholder='Usuario' value={user} onChange={e => setUser(e.target.value)}/>
```

* full example
```javascript
import './App.css';
import React, { useState } from 'react';
import axios from 'axios';

function App(props) {

  const [user, setUser] = useState("");

  function handlePesquisa() {
    axios.get(`https://api.github.com/users/${user}/repos`)
    .then(response => 
      {
        console.log(response.data)
      });
    }

  return (
    <>
      <input className='usuarioInput' placeholder='Usuario' value={user} onChange={e => setUser(e.target.value)}/>
      <button type='button' onClick={handlePesquisa}>Pesquisar</button>
    </>
  );
}

export default App;
```

## ROUTER
```javascript
import React from "react";
import {Routes, BrowserRouter, Route,  } from "react-router-dom";
import Home from "./Home";

import Repositories from "./Repositories";

export default function Routers() {
  return (
          <BrowserRouter>
            <Routes>
              <Route path="/" exact element={<Home/>} />
              <Route path="/repositories" element={<Repositories/>} />
            </Routes>
          </BrowserRouter>
  );
}
```

* injecting, the _Home_ component is the _default_
```javascript
import React from 'react';
import Routers from './routes';

function App() {
  return (
    <Routers/>
  );
}

export default App;
```