$raw
#version 430

#extension GL_EXT_geometry_shader4 : enable
#extension GL_NV_geometry_shader_passthrough : require
#extension GL_ARB_separate_shader_objects : enable

#include <bgfx_shader.sh>

layout(triangles) in;
layout(passthrough) in gl_PerVertex {
    vec4 gl_Position;
};

layout(location=0, passthrough) in vec3 v_view[];
layout(location=1, passthrough) in vec3 v_normal[];
layout(location=2) in vec3 v_world[];

// passthrough: layout(location=0, passthrough) out vec3 v_view; 
// passthrough: layout(location=1, passthrough) out vec3 v_normal; 
layout(location=2) out vec3 v_worldPos0;
layout(location=3) out vec3 v_worldPos1;
layout(location=4) out vec3 v_worldPos2;

void main() {
    v_worldPos0 = v_world[0];
    v_worldPos1 = v_world[1];
    v_worldPos2 = v_world[2];
}
