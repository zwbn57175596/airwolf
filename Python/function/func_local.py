#!/usr/bin/python
# Filename: func_local.py

def func(x):
	print 'x is ', x
	x = 2
	print 'Change local x to ', x

x = 50
func(x)
print 'x is still', x
