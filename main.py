#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import sys
from extra import *
from util import *
from engine import *
from fitness import *



"""
    Method used to create a first solution
"""
def init_function():

    #Define where the strings have been created
    directory = '/home/stevao/Workspace/acm_sac/'  #Force to use this directory

    #Call the java program to generate the search_string neighborhood
    java_program_call()

    #Used to caugth the values from the genereted files
    original_string = ''  #original string
    neighbor_list = []   #List with the neighborhood of the original_string

    #Run over all directories and extract the information from each file
    original_string, neighbor_list = get_all_strings(directory)

    #Now we hava all information. Need evaluate the original string

    #Just logging some information..
    info = 'I: Candidate string: %s \n' % original_string

    if log:
        i = 1
        log.write(info)

        for n in neighbor_list:
            info = 'I: Neighbor %d: %s \n' % (i,n)
            i = i + 1

    else:
        print info
        i = 1
        for n in neighbor_list:
            info = 'I: Neighbor %d: %s \n' % (i,n)
            print info
            i = i + 1


    return original_string, neighbor_list



"""
    Method used to assign a numerical score to a solution – how “good” the solution is
"""
def objective_function(original_string):

        #Generete the xml from that string
        get_ieee_xml(original_string)

        #Now will process the XML genereted. This will return a list with all studies returned by the search
        studies = process_xml()  #studies is a list with the following model for each item: [title ,author,abstract,keys]

        #Check if there is a valid list retrived from XML.. If ocurred some error, just define a negative value to the fitness
        if (len(studies)) > 0:

            #get the list of control studies
            control_studies_list = get_control_list()

            #Need evaluate this string
            total_fitness = fitness_function(studies, control_studies_list)

        else:
            total_fitness = -1

        return total_fitness



"""
    Simple Hill climb implementation..
"""
def hillclimb(init_function, objective_function, max_evaluations, log = None):

    """
        parameters:
            init_function – the function used to create our initial solution
            move_operator – the function we use to iterate over all possible “moves” for a given solution
            objective_function – used to assign a numerical score to a solution – how “good” the solution is
            max_evaluations – used to limit how much search we will perform (how many times we’ll call the objective_function)
    """

    directory = '/home/stevao/Workspace/acm_sac/'  #Force to use this directory
    empty = "\"\"" #empty therm to look at the string

    current_string, neighbor_list = init_function()  #original
    best_score = objective_function(current_string) #get the best score to original string

    num_evaluations = 1

    #Improve string will try add some synomous to the original string generating a extra neighborhood
    if best_score < 0:
        neighbor_list = improve_string(current_string, directory)

    while num_evaluations < max_evaluations:

        info = 'I: ============== Running Hill Climbing. Evaluation: %d ============== \n' % (num_evaluations)

        #Just logging
        if log:
            log.write(info)
        else:
            print info

        # examine moves around our current position
        move_made = False
        i = 0 #index

        while i < len(neighbor_list):
        #for neighbor in neighbor_list:

            neighbor = neighbor_list[i]

            info = 'I: Will evaluate the following string: %s \n' % (neighbor)

            #Just logging
            if log:
                log.write(info)
            else:
                print info


            if num_evaluations >= max_evaluations:
                break

            # see if this move is better than the current
            next_score = objective_function(neighbor)

            #Invalid string or dont return nothing..
            if next_score < 0:

                #Check if there is a empty therm into the string. If there is it, create a extra neighborhood with the synonymous
                if empty in neighbor:

                    #Log test..
                    if log:
                        extra_neighborhood = improve_string(neighbor, directory, log)
                    else:
                        extra_neighborhood = improve_string(neighbor, directory)

                    #At the end add the extra neighborhood to the original neighbor list..
                    neighbor_list = neighbor_list + extra_neighborhood


            info = 'I: Fitness produced: %f \n' % next_score
            info2 = 'I: Evaluation: %d \n' % num_evaluations

            #Just logging
            if log:
                log.write(info)
                log.write(info2)
            else:
                print info
                print info2


            if next_score > best_score:

                info = 'I: Find a better solution! \n'

                info2 = 'I: Current string: ', current_string
                info3 = 'I: Current fitness: ', best_score
                info4 = 'I: Better string: ', neighbor
                info5 = 'I: Better fitness: ', next_score
                info6 = 'I: Number of evaluations until the moment: %d \n' % (num_evaluations)

                #Just logging
                if log:
                    log.write(info)
                    log.write(info2)
                    log.write(info3)
                    log.write(info4)
                    log.write(info5)
                    log.write(info6)
                else:
                    print info
                    print info2
                    print info3
                    print info4
                    print info5
                    print info6


                current_string = neighbor
                best_score = next_score
                move_made = True

                break # depth first search

            i = i + 1 #increase the loop index

        #Increase the number of evaluations
        num_evaluations += 1

        if not move_made:

            info = 'I: The neighborhood of this iteration produced no string better than the  candidate string: %s \n' % (current_string)
            info = 'I: Fitness obtained: %f \n' % best_score

            #Just logging
            if log:
                log.write(info)
                log.write(info2)
            else:
                print info
                print info2


            break    # we couldn't find a better move. (must be at a local maximum)


        info = 'I: Updating the source files.. \n'

        #Just logging
        if log:
            log.write(info)
        else:
            print info


        #Update the files
        update_search_string_files(current_string)

        info = 'I: Generating the neighborhood to the candidate string: %s \n' % (current_string)

        #Just logging
        if log:
            log.write(info)
        else:
            print info


        #Run a new search to get the newest neighborhood
        current_string, neighbor_list = init_function()

    #return number of evaluations, the best score and the initial solution
    return (num_evaluations,best_score,current_string)



"""
    Make a system call to the jar file. Purpose: Create the directories with the neighborhood strings
"""
def java_program_call():

    #Create the java statement
    stm = 'java -jar ACM_Sac-String.jar StringGen.txt Original.txt'

    #Execute java program
    os.system(stm)



if __name__ == '__main__':

    #Verify the execution
    if len(sys.argv) < 2:
        print 'Usage: python main.py int::max_evaluations'
        sys.exit(0)

    max_evaluations = int(sys.argv[1])

    #Define the log variable. If it's None so print the information in terminal. If it's a file, all the information will be saved inside this file.
    log = None
    #log = file('log.txt', w+)

    info = "I: ============== Starting a new execution ============== \n"

    if log:
        log.write(info)
    else:
        print info

    #If log save the information into a file, else just print everything into console
    if log:
        hillclimb(init_function, objective_function, max_evaluations, log)
    else:
                hillclimb(init_function, objective_function, max_evaluations)
