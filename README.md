[![Build Status][build-shield]][build-url]
[![Codacy Status][codacy-shield]][codacy-url]
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![License][license-shield]][license-url]

# TP2 Algoritmos 3: AlgoBlocks <img height="35" src="https://raw.githubusercontent.com/valva-ro/Algo3-TP2-AlgoBlocks/master/src/main/resources/logo.png">

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo N7
* [Alejo Villores](https://github.com/alejovillores)
* [Andreas Kuballa](https://github.com/AndreasKub)
* [Kevin Meaca](https://github.com/root-MKevin)
* [Valentina Varela Rodriguez](https://github.com/valva-ro)


Corrector: [Tomas Bustamante](https://github.com/tomasBustamante)

## Pre-requisitos

Las herramientas necesarias para trabajar en el proyecto son el entorno de desarollo
([Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)),
[Apache Maven](https://maven.apache.org) para la construcción automatizada y Git para el control de versiones

Para verificar que se haya instalado todo correctamente:
```console
    javac -version
    javac 11.0.10
    
    mvn --version
    Apache Maven 3.6.3
    Maven home: C:\Program Files\apache-maven-3.6.3\bin\..
    Java version: 11.0.10, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.10
    Default locale: es_419, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ...
    
    git --version
    git version 2.25.1
```

## Instalacion
Para iniciar el respositorio local:
```console
    mkdir AlgoBlocks
    cd AlgoBlocks
    git init
    git remote add origin https://github.com/valva-ro/Algo3-TP2-AlgoBlocks.git
```

## Ejecutando las pruebas

```bash
    mvn test
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  11.705 s
    [INFO] Finished at: 2021-03-04T15:48:25-03:00
    [INFO] ------------------------------------------------------------------------
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

## Ejecutando la aplicación

```bash
    mvn compile
    mvn clean javafx:run
```

## Licencia

Este repositorio está bajo la [Licencia MIT][license-url]

[build-shield]: https://api.travis-ci.org/valva-ro/Algo3-TP2-AlgoBlocks.svg?branch=master
[build-url]: https://travis-ci.org/github/valva-ro/Algo3-TP2-AlgoBlocks
[codacy-shield]: https://app.codacy.com/project/badge/Grade/f0b33f5e35db4547877aa69fa122f435
[codacy-url]: https://www.codacy.com/gh/valva-ro/Algo3-TP2-AlgoBlocks/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=valva-ro/Algo3-TP2-AlgoBlocks&amp;utm_campaign=Badge_Grade
[contributors-shield]: https://img.shields.io/github/contributors/valva-ro/Algo3-TP2-AlgoBlocks.svg?style=flat-square
[contributors-url]: https://github.com/valva-ro/Algo3-TP2-AlgoBlocks/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/valva-ro/Algo3-TP2-AlgoBlocks.svg?style=flat-square
[forks-url]: https://github.com/valva-ro/Algo3-TP2-AlgoBlocks/network/members
[stars-shield]: https://img.shields.io/github/stars/valva-ro/Algo3-TP2-AlgoBlocks.svg?style=flat-square
[stars-url]: https://github.com/valva-ro/Algo3-TP2-AlgoBlocks/stargazers
[issues-shield]: https://img.shields.io/github/issues/valva-ro/Algo3-TP2-AlgoBlocks.svg?style=flat-square
[issues-url]: https://github.com/valva-ro/Algo3-TP2-AlgoBlocks/issues
[license-shield]: https://img.shields.io/github/license/valva-ro/Algo3-TP2-AlgoBlocks.svg?style=flat-square
[license-url]: https://github.com/valva-ro/Algo3-TP2-AlgoBlocks/blob/master/LICENSE.md
