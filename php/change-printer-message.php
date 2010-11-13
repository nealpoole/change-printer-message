#!/usr/bin/env php
<?php

if ($argc != 3)
	die('ERROR: Need to specify both a printer address and a message' . "\n");

$f = fsockopen($argv[1], 9100);
fwrite($f, "\x1B%-12345X@PJL RDYMSG DISPLAY = \"" . $argv[2] . "\"\r\n\x1B%-12345X\r\n");
fclose($f);

die('Message successfully sent to printer' . "\n");
