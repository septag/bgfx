$raw
#version 430
#extension GL_ARB_explicit_attrib_location : enable
#extension GL_ARB_separate_shader_objects : enable

layout(location=0) in vec3 a_position;
layout(location=2) in vec3 a_normal;

layout(location=0) out vec3 v_view;
layout(location=1) out vec3 v_world;

/*
 * Copyright 2016 Dario Manesku. All rights reserved.
 * License: https://github.com/bkaradzic/bgfx#license-bsd-2-clause
 */

#include "../common/common.sh"
#include "uniforms.sh"

void main()
{
	gl_Position = mul(u_modelViewProj, vec4(a_position, 1.0) );
	vec3 worldPos = mul(u_model[0], vec4(a_position, 1.0) ).xyz;
	v_view = u_camPos - worldPos;
	v_world = worldPos;
}

