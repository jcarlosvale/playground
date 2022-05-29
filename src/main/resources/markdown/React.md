#REACT

## Links

* [REACT](https://reactjs.org/)

* [AXIOS](https://github.com/axios/axios)
  * npm install axios

* [ROUTER](https://v5.reactrouter.com/web/guides/quick-start)
  * npm install react-router-dom

* [STYLED-COMPONENTS](https://styled-components.com/)
  * npm install styled-components


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

* using navigate

```javascript
import { useNavigate } from 'react-router-dom';

...

export default function Home(props) {

  const navigate = useNavigate();
  const [user, setUser] = useState("");

  function handlePesquisa() {
    axios.get(`https://api.github.com/users/${user}/repos`)
            .then(response => {
              const repositories = response.data;
              const repositoriesName = [];
              repositories.map(repository => repositoriesName.push(repository.name));
              localStorage.setItem('repositoriesName', JSON.stringify(repositoriesName));
              console.log(repositoriesName);
              navigate('/repositories');
            });
  }
...
```
* using Link

```javascript
import { Link } from "react-router-dom";
...
<Link to='/'>Voltar</Link>
```

### Using local storage

```javascript
  function handlePesquisa() {
  axios.get(`https://api.github.com/users/${user}/repos`)
          .then(response => {
            const repositories = response.data;
            const repositoriesName = [];
            repositories.map(repository => repositoriesName.push(repository.name));
            localStorage.setItem('repositoriesName', JSON.stringify(repositoriesName));
            console.log(repositoriesName);
          });
}
```

## Styled-Components

* to style elements, like:

```javascript
import styled from 'styled-components';


export const Container = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
`;


export const Input = styled.input`
    border: 1px solid #ddd;
    height: 1.5rem;
    padding: 0 .5rem;
    border-radius: .25rem 0 0 .25rem;

    &:focus,
    &:active {
        outline: none;
        box-shadow: none;
    }
`;

export const Button = styled.button`
    height: 1.5rem;
    border: 1px solid #000;
    background: #000;
    color: #fff;
    border-radius: 0 .25rem .25rem 0;
`;
```

* usage example
```javascript
import * as S from './styled';

  return (
    <S.Container>
      <S.Input className='usuarioInput' placeholder='Usuario' value={user} onChange={e => setUser(e.target.value)}></S.Input>
      <S.Button type='button' onClick={handlePesquisa}>Pesquisar</S.Button>
    </S.Container>
  );
```

* styling in react components
```javascript
import { Link } from "react-router-dom";

export const LinkHome = styled(Link)`
    display: block;
    width: 4rem;
    text-align: center;
    margin: 2rem auto;
    background-color: #000;
    padding: .5rem 0;
    color: #fff;
    text-decoration: none;
`;
```

### Conditional Rendering

* verify the error variable below

```javascript
import '../../App.css';
import React, { useState } from 'react';
import axios from 'axios';
import * as S from './styled';
import { useNavigate } from 'react-router-dom';

export default function Home(props) {

  const navigate = useNavigate();
  const [user, setUser] = useState("");
  const [error, setError] = useState(false);

  function handlePesquisa() {
    axios.get(`https://api.github.com/users/${user}/repos`)
    .then(response => {
        const repositories = response.data;
        const repositoriesName = [];
        repositories.map(repository => repositoriesName.push(repository.name));
        localStorage.setItem('repositoriesName', JSON.stringify(repositoriesName));
        console.log(repositoriesName);
        setError(false);
        navigate('/repositories');
      })
    .catch(error => {
        setError(true)
      });
    }

  return (
    <S.HomeContainer>
      <S.Container>
        <S.Input className='usuarioInput' placeholder='Usuario' value={user} onChange={e => setUser(e.target.value)}></S.Input>
        <S.Button type='button' onClick={handlePesquisa}>Pesquisar</S.Button>
      </S.Container>
      {
        error ? <S.ErrorMsg>Ocorreu um erro. Tente novamente.</S.ErrorMsg> : ' '
      }
      
    </S.HomeContainer>
  );
}
```

