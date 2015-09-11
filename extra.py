#!/usr/bin/env python
# -*- coding: utf-8 -*-


import os
import sys
from util import *


"""
	This method is used to generate a extra neighborhood based in the synonymous list
"""
def generate_extra_neighborhood(directory,current_string, position, syn_dic, log = None):

	"""
		Args:
			current_string = string with a invalid fitness. Will generate the neighborhood based in this string
			position = position of the synonymous in the file
			syn_dic  = a dictionary. Index = A numeber that identifies the position of a therm in the string. Key = a list with possible synonymous for that therm

	"""

	file_name = 'extra.txt'

	current_string_list = []
	broken_part = []

	#Break current string into a list
	current_string_list = break_string_in_list(current_string)
	broken_part = current_string_list[position]

	#get the list of synonymous for a therm in the "position" in the string
	synonymous_list = syn_dic[position]
	updated_string_list = []


	info = 'Current string list: ', current_string_list
	info2 = 'Broken part: ', broken_part
	info3 = 'Avaliable synonymous: ', synonymous_list

	#Just logging
	if log:
		log.write(info)
		log.write(info2)
		log.write(info3)
	else:
		print info
		print info2
		print info3

	neighbor_extra = []

	for syn in synonymous_list:

		fixed_part = [] #list with the correct therms

		#Replace the empty therm by a synonymou
		for e in broken_part:

			if e == '':
				e = syn

			#Fix the empty therm
			fixed_part.append(e)

		info = 'Updated part with synonymou: ', fixed_part

		#Just logging
		if log:
			log.write(info)
		else:
			print info


		#Fix the string..
		updated_string_list = [fixed_part if e == broken_part else e for e in current_string_list]

		info = 'Updated string: ', updated_string_list


		#Just logging
		if log:
			log.write(info)
		else:
			print info


		#Now need to update the extra file before run the java program
		update_search_string_files(updated_string_list, file_name, file_name)

		#Create the java statement using the extra file
		stm = 'java -jar ACM_Sac-String.jar extra.txt extra.txt'

		#Execute java program
		os.system(stm)

		#Run over all directories and extract the information from each file
		original_string, neighbor_list = get_all_strings(directory)

		neighbor_extra.append(original_string)

	fixed_part2 = []

	for p in pairs(synonymous_list):
		p = list(p)

		for e in broken_part:

			if e == '':
				e = p

			fixed_part2.append(e)
			#break

	#Fix the string..
	updated_string_list = [fixed_part2 if e == broken_part else e for e in current_string_list]

	info = 'Updated string: ', updated_string_list, '\n'

	#Just logging
	if log:
		log.write(info)
	else:
		print info


	#Now need to update the extra file before run the java program
	update_search_string_files(updated_string_list, file_name, file_name)

	#Create the java statement using the extra file
	stm = 'java -jar ACM_Sac-String.jar extra.txt extra.txt'

	#Execute java program
	os.system(stm)

	#Run over all directories and extract the information from each file
	original_string, neighbor_list = get_all_strings(directory)

	neighbor_extra.append(original_string)

	return neighbor_extra


"""
	This method read the synonymous file and create a dictionary where each element is a list with the synonymous of one therm of the string
"""
def get_synonymous():

	#The file will always be the same
	synonymous_file = open('Sinonimos.txt','rb')

	#this will informe the index of the list of synonymous that have to be used
	index = 0

	#Create a var to recive the value of the synonymous.txt and a list to break them after..
	file_txt = str()
	syn_dic = {}  #dictionary of synonymous

	#Every line in the file is correspondent to a synonymou. So just go through the lines removes the "\ n" and add to the list
	for line in synonymous_file:

		#If the line is a \n increase the index of synonymous
		if line == '\n':
			index = index + 1
			continue

		line = line.strip('\n')

		#First iteration. There is nothing inside the dic, so create the first item
		if not index in syn_dic.keys():

			syn_dic[index] = [line]

		#Already have some thing soo add the new value to the previous
		else:
			syn_dic[index] = syn_dic[index] + [line]

		#Close the file
		synonymous_file.close

	return syn_dic



"""
	Get the therms of the synonymous list and create a extra neighborhood
"""
def improve_string(current_string, directory, log = None):

	info = 'I: Will generate a extra neighborhood based on the synonymous list! \n'


	#Just logging
	if log:
		log.write(info)
	else:
		print info


	#break the current string into a list
	list_current_string = break_string_in_list(current_string)

	#This will be the position of the deleted therms of the string
	therms = None

	info = 'String used to generate new neighborhood: ' ,list_current_string

	#Just logging
	if log:
		log.write(info)
	else:
		print info


	incomplete_therms = []

	#Each therms is a list with one therm or more therms
	for therms in list_current_string:
		#Get the position of the empty therm
		for t in range(0,len(therms)):

			info = 'Therm: ', therms[t]

			#If the list of therms is '' that means that therms has been deleted by one neighborhood. Will return the position of that element
			if "" in therms:

				#get the list with the empty therm
				incomplete_therms = therms
				break #stop the iteration


	#get the position of the synonymous that need to be used
	position = list_current_string.index(incomplete_therms)

	info = "Incomplete Therms: ", incomplete_therms
	info2 = "Position of the incomplete therms in the string: ", position

	#Just logging
	if log:
		log.write(info)
		log.write(info2)
	else:
		print info
		print info2

	#Verify if the loop find a valid position value. If get inside this statment you neeed to improve the solution
	if not therms:
		info = 'Your logic is dumbed try something better! (extra.py:improve_string())'

		#Just logging
		if log:
			log.write(info)
		else:
			print info

		sys.exit(0)

	#If everything goes fine then always get inside this else..
	else:

		syn_dic = {}  #dictionary of synonymous

		syn_dic = get_synonymous() #get the dictionary of synonymous

		#current_string, Position of the synonymous that have to be used and the directory of synonymous

	extra_neighborhood = generate_extra_neighborhood(directory, current_string, position, syn_dic)

	return extra_neighborhood
