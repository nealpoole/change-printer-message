#!/usr/bin/env ruby
require 'socket'

abort "ERROR: Need to specify both a printer address and a message" unless ARGV.length == 2

s = TCPSocket.open(ARGV[0], 9100)
s.puts("\x1B%-12345X@PJL RDYMSG DISPLAY = \"" + ARGV[1] + "\"\r\n\x1B%-12345X\r\n")
s.close

puts "Message successfully sent to printer"
