#!/usr/bin/python
# Filename: backup_ver1.py

import os
import time

# 1. The files and directories to be backed up are specified in a list
# source = ['/home/swaroop/byte', '/home/swaroop/bin']
# If you are using windows, use 
source = [r'D:\\opt', r'D:\\patches']
# or something like that

# 2. The backup must be stored in a main backup directory
target_dir = r'D:\\backup\\d\\' # Remeber to change this to what you will be using

# 3. The files are backed up into a zip file.
# 4. The name of the zip zrchive is the current date and time
target = target_dir + time.strftime('%Y%m%d%H%M%S') + '.zip'

# 5. We use the zip command (in Unix/Linux) to put the files in a zip archive
zip_command = "zip -qr %s %s" % (target, ' '.join(source))

# Run the backup
if os.system(zip_command) == 0:
	print 'Successful backup to', target
else:
	print 'Backup FAILED'

