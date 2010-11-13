#!/usr/bin/env python
import socket
import sys

if len(sys.argv) != 3:
	print("ERROR: Need to specify both a printer address and a message")
	sys.exit()

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((sys.argv[1], 9100))
s.send("\x1B%-12345X@PJL RDYMSG DISPLAY = \"" + sys.argv[2] + "\"\r\n\x1B%-12345X\r\n")
s.close()

print("Message successfully sent to printer")
