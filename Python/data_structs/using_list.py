#!/usr/bin/python
# Filename: using_list.py

# This is my shopping list
shoplist = ['apple', 'mango', 'carrot', 'banana']

print 'I have ', len(shoplist), ' items to purchase.'

print 'These items are: ', # Notice the comma at then of the line
for item in shoplist:
	print item,

print '\nI alse have to by rice.'
shoplist.append('rice')
print 'My shopping list is now ', shoplist

print 'I will sort my list now'
shoplist.sort()
print 'Sorted shopping list is ', shoplist

print 'The first item i will by is', shoplist[0]
olditem = shoplist[0]
del shoplist[0]
print 'I bought the ', olditem
print 'My shopping list is now', shoplist