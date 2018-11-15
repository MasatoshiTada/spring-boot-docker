#!/usr/bin/env bash
docker container stop spring-boot-docker_boot-ui_1
docker container stop spring-boot-docker_boot-api_1
docker container stop spring-boot-docker_postgresql94_1
docker container rm spring-boot-docker_boot-ui_1
docker container rm spring-boot-docker_boot-api_1
docker container rm spring-boot-docker_postgresql94_1
docker image rm spring-boot-docker_boot-ui
docker image rm spring-boot-docker_boot-api