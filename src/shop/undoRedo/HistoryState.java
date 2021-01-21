package shop.undoRedo;

public class HistoryState {
    HistoryCommand undo;
    HistoryCommand redo;

    public HistoryState(HistoryCommand undo, HistoryCommand redo) {
        this.undo = undo;
        this.redo = redo;
    }
}
