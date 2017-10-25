package fishsim;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The Herring fish class
 * @author Mayra Dantas de Azevedo
 * @version 03/10/2017
 */
public class Herring extends Fish {
	private double planctonEaten;

	/**
	 * Construct a new herring
	 * @param cell fish location
	 * @param params parameters for the new fish
	 */
	public  Herring(Cell cell, FishParams params) {
		super(cell, params);
		planctonEaten = params.getPlanctonEaten();
		status = 1;
	}

	/**
	 * Return a new fish of the same kind
	 * @param cell fish location
	 * @return new fish
	 */
	public Fish spawn(Cell cell) {
		return cell.createFish("herring");
	}

	/**
	 * Iterate this fish through one simulator cycle
	 * @param step counter that should be incremented for each
	 * call. Used to avoid the same fish acting more than once
	 * in a cycle
	 */
	public void act(int step) {
		if (this.step == step)
			return;
		this.step = step;
		age++;
		
		if( isAlive() )

		// Eat some plancton

		// burn some weight and see if we are still viable
		weight *= weightReduce;

		// look for the neighboring cell with the most plancton
		// and no other fish
		Cell bestNeighbour = null;
		Cell cells[] = cell.neighbours(1);
		for (Cell c: cells) {
			if (c.getFish() != null)
				continue;
			if (bestNeighbour == null || c.getPlancton() > bestNeighbour.getPlancton())
				bestNeighbour = c;
		}
		if (bestNeighbour == null)
			return;

		// Either spawn into the neighboring cell or if we can't
		// breed, move into it.
		if (weight >= breedWeight && age > breedAge)
		{
			Fish child = spawn(bestNeighbour);
			child.setWeight(weight * 0.4);
			weight *= 0.6;
		} else if (bestNeighbour.getPlancton() > cell.getPlancton())
			move(bestNeighbour);
	}

	@Override
	public void eat(List<Cell> neighborhood) {
		// Eat some plancton
		double p = cell.getPlancton();
		if (p > planctonEaten) {
			eat(planctonEaten);
			p -= planctonEaten;
		} else {
			eat(p);
			p = 0.1; // don't reduce to zero
		}
		cell.setPlancton(p);

	}

	/**
	 * Checks if fish is alive.
	 * @return True if fish is alive, false otherwise.
	 */
	@Override
	public boolean isAlive() {
		age++;
		return age < maxAge && weight >= viableWeight;
	}

	/**
	 * Move fish to another cell.
	 * @param current Cell that contains the fish
	 * @param neighborhood List of cells that can be occupied.
	 */
	@Override
	public void move(Cell current, List<Cell> neighborhood) {

		Collections.shuffle(neighborhood);
		for (Cell c: neighborhood) {
			if (c.getFish() != null && c.getPlancton() >  current.getPlancton()) {
				Fish fish = current.getFish();
				current.setFish(null);
				c.setFish(fish);
				break;
			}
		}

	}

	/**
	 * Fish breed and spawn to neighbor cell.
	 * @param neighborhood List of cells that can be occupied.
	 */
	@Override
	public void breed(List<Cell> neighborhood) {
		if (weight >= breedWeight && age > breedAge)
		{
			Collections.shuffle(neighborhood);
			for (Cell c: neighborhood) {
				if (c.getFish() != null) {
					Fish child = c.createFish("herring");
					child.setWeight(weight * 0.4);
					break;
				}
			}
			weight *= 0.6;
		}

	}
}
