package others;

class CodedList {
    int[] codedList;
    int currentPair;
    int currentPairCount;

    CodedList(int[] input) {
        codedList = input;
        currentPair = 0;
        currentPairCount = codedList[currentPair];
        establishInvarient();
    }

    boolean hasNext() {
        return currentPair <= codedList.length - 2;
    }

    int getNext() {
        if (hasNext()) {
            assert (currentPairCount > 0);
        }
        int result = codedList[currentPair + 1];
        currentPairCount--;
        establishInvarient();
        return result;
    }

    /*
     * Maintain the invarient that currentPairCount is always positive when
     * hasNext(). I find having such a helper function is a very useful
     * technique.
     */
    private void establishInvarient() {
        while (currentPairCount == 0) {
            currentPair = currentPair + 2;
            if (hasNext()) {
                currentPairCount = codedList[currentPair];
            } else {
                break;
            }
        }
    }
}
