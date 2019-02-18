#!/bin/bash

shaderc -f vs_wf_wireframe.sc --platform linux --type vertex --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/vs_wf_wireframe.bin -i . -i ../../src
shaderc -f fs_wf_wireframe.sc --platform linux --type fragment --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/fs_wf_wireframe.bin -i . -i ../../src

shaderc -f vs_wf_mesh.sc --platform linux --type vertex --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/vs_wf_mesh.bin -i . -i ../../src
shaderc -f fs_wf_mesh.sc --platform linux --type fragment --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/fs_wf_mesh.bin -i . -i ../../src

shaderc -f vs_wf_wireframe_nv.sc --platform linux --type vertex --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/vs_wf_wireframe_nv.bin -i . -i ../../src -p 430
shaderc -f fs_wf_wireframe_nv.sc --platform linux --type fragment --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/fs_wf_wireframe_nv.bin -i . -i ../../src -p 430
shaderc -f gs_wf_wireframe_nv.sc --platform linux --type geometry --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/gs_wf_wireframe_nv.bin -i . -i ../../src -p 430

shaderc -f vs_wf_mesh_nv.sc --platform linux --type vertex --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/vs_wf_mesh_nv.bin -i . -i ../../src -p 430
shaderc -f fs_wf_mesh_nv.sc --platform linux --type fragment --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/fs_wf_mesh_nv.bin -i . -i ../../src -p 430
shaderc -f gs_wf_mesh_nv.sc --platform linux --type geometry --varyingdef varying.def.sc  -o ../runtime/shaders/glsl/gs_wf_mesh_nv.bin -i . -i ../../src -p 430
