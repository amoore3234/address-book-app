# address-book-backend-app
An app that contains a list of address records.

# Table of Contents
- [Introduction](#introduction)
- [Prerequisites](#prerequistes)
- [Installation](#installation)
    - [NodeJs installation for macOS version 11 or less](nodejs-installation-for-macOS-version-11-or-less)
- [Dev Links](#dev-links)

# Introduction
The Address Book application is a small application that allows users to search through a list of address records that contains a person's name, home address, and contact information. The user is presented with a search bar where an individual can be searched through an address directory.

# Prerequistes
- [Docker](https://www.docker.com/get-started/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/)
- [NodeJS](https://nodejs.org/en/download)
- **For Windows (WSL):**
  - [WSL 2](https://learn.microsoft.com/en-us/windows/wsl/install)
  - [Ubuntu](https://documentation.ubuntu.com/wsl/latest/howto/install-ubuntu-wsl2/)
    - **Note:** If there is an issue starting the docker engine, you may need to add the user to the docker group. you can run this command:
      - `sudo usermod -aG docker $USER`

# Installation

## NodeJs installation for macOS version 11 or less
The Job Link application is currently configured to support macOS with versions 11 or lower. To run the application locally successully, install node using version v20.19.6 or v18.20.8 and Vite version 4(vite@4).

 # Dev Links
 - [Address Book App React UI](http://localhost:5137/)
