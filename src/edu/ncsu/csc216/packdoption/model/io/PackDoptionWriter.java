package edu.ncsu.csc216.packdoption.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import edu.ncsu.csc216.packdoption.model.animals.Animal;
import edu.ncsu.csc216.packdoption.model.animals.Cat;
import edu.ncsu.csc216.packdoption.model.animals.Dog;
import edu.ncsu.csc216.packdoption.model.rescue.RescueList;

/**
 * The purpose of the PackDoptionWriter class is to be able to save all of the information
 * held within the program to a file. The Class PackDoptionWriter only contains one method
 * that is responsible for exporting a RescueList to a particular file on the users personal system. 
 * 
 * @author Cameron Dutra
 * @author Ian Fright
 */
public class PackDoptionWriter {
	
	/**
	 * Currently not responsible for anything
	 */
	public PackDoptionWriter() {
		//Does nothing
	}
	
	/**
	 * Write the specified RescueList to the specified file in the correct format.
	 *
	 * @param fileName the filename to export to
	 * @param rescueList the rescue list to export
	 * @throws IllegalArgumentException if there is an issue writing to the file
	 */
	public static void writeRescueFile(String fileName, RescueList rescueList) {
		PrintStream fileWriter = null;
		try {
    		fileWriter = new PrintStream(new File(fileName));
    		for (int i = 0; i < rescueList.size(); i++) {
				if (i > 0) {
					fileWriter.println();
				}
				fileWriter.println("# " + rescueList.getRescue(i).toString());
				for (int j = 0; j < rescueList.getRescue(i).numAnimals(); j++) {
					if (j < rescueList.getRescue(i).numAnimals() - 1) {
						if (rescueList.getRescue(i).getAnimal(j) instanceof Cat) {
							Cat catPrint = (Cat)rescueList.getRescue(i).getAnimal(j);
							fileWriter.println("* " + catPrint.toStringAll());
						} else if (rescueList.getRescue(i).getAnimal(j) instanceof Dog) {
							Dog dogPrint = (Dog)rescueList.getRescue(i).getAnimal(j);
							fileWriter.println("* " + dogPrint.toStringAll());
						}
					} else {
						if (rescueList.getRescue(i).getAnimal(j) instanceof Cat) {
							Cat catPrint = (Cat)rescueList.getRescue(i).getAnimal(j);
							fileWriter.print("* " + catPrint.toStringAll());
						} else if (rescueList.getRescue(i).getAnimal(j) instanceof Dog) {
							Dog dogPrint = (Dog)rescueList.getRescue(i).getAnimal(j);
							fileWriter.print("* " + dogPrint.toStringAll());
						}
					}
				}
				fileWriter.println();
				for (int j = 0; j < rescueList.getRescue(i).getAppointments().size(); j++) {
					Animal queueElement = rescueList.getRescue(i).getAppointments().element();
					if (j < rescueList.getRescue(i).getAppointments().size() - 1) {
						fileWriter.println("- " + queueElement.getName() + "," + queueElement.getBirthday().toString());
					} else {
						fileWriter.print("- " + queueElement.getName() + "," + queueElement.getBirthday().toString());
					}
					Animal queueRemoved = rescueList.getRescue(i).getAppointments().remove();
					rescueList.getRescue(i).addAppointment(queueRemoved);
				}
				fileWriter.println();
			}
    		if (rescueList.size() > 0) {
        		fileWriter.println();
    		}
		} catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to save file.");
		}
		fileWriter.close();
	}
}
