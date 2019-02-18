$raw
#version 430

#extension GL_ARB_separate_shader_objects : enable
#extension GL_OES_standard_derivatives : enable

layout(location=0) in vec3 v_view;
layout(location=1) in vec3 v_worldPos0;
layout(location=2) in vec3 v_worldPos1;
layout(location=3) in vec3 v_worldPos2;

/*
 * Copyright 2016 Dario Manesku. All rights reserved.
 * License: https://github.com/bkaradzic/bgfx#license-bsd-2-clause
 */

#include <bgfx_shader.sh>
#include "uniforms.sh"

vec3 intersectRayTri(vec3 rayOrigin, vec3 rayDirection, vec3 v0, vec3 v1, vec3 v2)
{
	vec3 e0 = v1 - v0;
	vec3 e1 = v2 - v0;
	vec3 s1 = cross(rayDirection, e1);
	float  invd = 1.0 / (dot(s1, e0));
	vec3 d = rayOrigin - v0;
	float  b1 = dot(d, s1) * invd;
	vec3 s2 = cross(d, e0);
	float  b2 = dot(rayDirection, s2) * invd;
	float temp = dot(e1, s2) * invd;

	return vec3(1.0 - b1 - b2, b1, b2);
}

void main()
{
	vec3  color   = u_wfColor;
	float opacity = u_wfOpacity;
	float thickness = u_wfThickness;
	if (gl_FrontFacing) { opacity *= 0.5; }

	vec3 bc = intersectRayTri(u_camPos, normalize(v_view), v_worldPos0, v_worldPos1, v_worldPos2);
	vec3 fw = abs(dFdx(bc)) + abs(dFdy(bc));
	vec3 val = smoothstep(vec3_splat(0.0), fw*thickness, bc);
	float edge = min(min(val.x, val.y), val.z); // Gets to 0.0 around the edges.
	vec4 rgba = vec4(color, (1.0-edge)*opacity);

	gl_FragColor = rgba;
}

