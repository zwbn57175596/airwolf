#!/usr/bin/python
# Filename: finally.py

import time

try:
	f = file('..\\IO\\poem.txt')
	while True: # our usual file-rading idiom
		line = f.readline()
		if len(line) == 0:
			break
		time.sleep(2)
		print line,
finally:
	f.close()
	print 'Cleaning up...closed the file'
