#!/usr/bin/env bash

# shellcheck disable=SC2164
cd src/main/resources
liquibase rollback-count --count=1