# TypeScript

## Commands:
* initialize a npm empty package (*package.json*)
```json
npm init -y

Wrote to C:\TypeScript\package.json:

{
  "name": "typescript",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}
```

* install typescript
```json
npm install --save-dev typescript
or
npm i -D typescript

added 1 package, and audited 2 packages in 3s

found 0 vulnerabilities
```

* typescript configuration
```json
npx tsc --init

Created a new tsconfig.json with:
                                                                                                         TS
  target: es2016
  module: commonjs
  strict: true
  esModuleInterop: true
  skipLibCheck: true
  forceConsistentCasingInFileNames: true


You can learn more at https://aka.ms/tsconfig.json
```

* compile ts
```
npx tsc

or

npx tsc --watch
```

* import node packages
```javascript
λ npm install @types/node
```

* modify your `package.json` to compile using `npm`:
  * add "build"
```json
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "build": "tsc"
```
```
npm run build
```

* uses `tsconfig.json` to modify the project configurations like:
  * "rootDir": "./src"
  * "outDir": "./build"
  * "noEmitOnError": true

## Data Types

### string

```ts
let nome: string;

nome = 'João';

function nomeCompleto(nome: string, sobrenome: string) {
  return nome + ' ' + sobrenome;
}

nomeCompleto('João', 'Silva');
```

### number

```ts
let idade: number;

idade = 25;

function somar(a: number, b: number) {
    return a + b;
}

somar(1,1);
somar(2,4);
```

### boolean

```ts
let active: boolean;

active = true;

function verificarAtivo(ativo: boolean) {
    if (active) {
        return 'Ativo';
    } else {
        return 'Inativo';
    }
}

verificarAtivo(false);
```

### array

```ts
const nomes: string[] = ['João', 'Maria', 'Pedro'];

function printNames(nomes: string[]) {
  return `nomes: ${nomes.join(', ')}`;
}

console.log(printNames(nomes));
```

### tuple

```ts
const pessoas: [string, string, string] = ['João', 'Maria', 'Pedro'];

const joao: [string, number] = ['João', 25];

const maria: [string, number] = ['Maria', 20];
```

### enum

```ts
enum Profiles{
    admin,
    editor, 
    user
}

enum Cores {
  red = '\u001b[31m',
  black = '\u001b[30m',
}

const usuario = {
    level: Profiles.admin
}

console.log(usuario);
```
### type alias

```ts
type User = {
  name : string;
  lastName: string;
  birthday: string;
  age?: number;  //optional
}

const user: User = {
  name: 'some name',
  lastName: 'some last name',
  birthday: '01/01/1900',
}
```

### union type
```ts
type LogLevel = 'info' | 'error' | 'debug'

function logMessage(message: string, level: LogLevel) {
  console.log(`[${level}] - ${message}`)
}

logMessage("A message", 'info')
```

### intersection types

```ts
type About = {
  bio: string;
  interests: string[];
}

type Profile = User & About;
const userWithProfile: Profile = {
  name: 'name',
  lastName: 'lastname',
  birthday: '01/01/1900',
  bio: 'bio',
  interests: ['games', 'sports'],
}
```

### other types
* **any**
  * type not defined;
```ts
let value: any;

value = 25;
value = '25';
```

* **unknown**
  * type _any_ + validations.
```ts
let informations: unknown;
let completeInformations: string;

completeInformations = informations; //don't compile, with any compile
```

* **undefined**
  * instances without values;

* **null**

* **object**

* **void**

* **never**, used in functions:
  * error return;
  * infinite loops;

## Objects

```ts
class User {
  
  public name;
  public idade;
  
  constructor(name: string, age: number) {
    this.name = name;
    this.age = age;
  }
}

//inheritance
class Player extends User {
  
  public game;
  
  constructor(name: string, age: number, game: string) {
    super(name, age);
    this.game = game;
  }
  
  currentGame() {
    return `I am playing ${this.game}`; 
  }
  
  static currentTime() {
    return Date();
  }
}

const user = new User("name", 15)
console.log(user)

const player = new Player("name", 18, "game");
console.log(player.currentGame());

//static
console.log(Player.currentTime());
```

### private x protected
```ts
class Game {
  private name;
  protected otherName;
  
  constructor(name: string, otherName: string) {
    this.name = name;
    this.otherName = otherName;
  }
  
  getName() {
    return name;
  }
}

class SpecialGame extends Game {
  private description;
  
  constructor(name: string, description: string) {
    super(name, "other");
    this.description = description;
  }
  
  getOtherName() {
    return this.otherName;
  }
}
```

### interface

```ts
interface IGame {
  getDescription(): string;
}

class Game implements IGame {
  
  getDescription(): string {
    return "";
  }
}

const objeto: IGame = {
  getDescription(): string {
    return "something";
  }
}
```

References:
[Typescript Lang](https://www.typescriptlang.org/)