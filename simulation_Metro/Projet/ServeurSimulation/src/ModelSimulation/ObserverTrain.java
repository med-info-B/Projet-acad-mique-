package ModelSimulation;

import java.util.List;


public interface ObserverTrain {
	public void notifyTrainEvent(List<Coordinate> positions);
}
