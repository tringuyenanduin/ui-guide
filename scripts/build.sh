#!/usr/bin/env bash

source ./scripts/_prepare.sh

# Resources
echo "[info] Copying resources ..."
cp ${core_res}/template.index.html ${docs}/index.html
cp ${core_res}/icon.png ${docs}/
sass ${core_css_main} ${docs}/app.css --style=compressed

# JS
echo "[info] Compiling JS (fullOpt) ..."
sbt fullOptJS
echo "[info] Copying JS ..."
cp ${core_target}/core-opt.js ${docs}/app.js
cp ${core_target}/core-jsdeps.min.js ${docs}/dep.js

echo -e "[\e[32msuccess\e[0m] Successfully built"