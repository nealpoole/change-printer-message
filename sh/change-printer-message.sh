#!/bin/sh
if [ "$#" -ne 2 ]; then
  echo "ERROR: Need to specify both a printer address and a message"
  exit 0
fi

echo -e "\x1B%-12345X@PJL RDYMSG DISPLAY = \"$2\"\r\n\x1B%-12345X\r\n" | nc -w 1 $1 9100
