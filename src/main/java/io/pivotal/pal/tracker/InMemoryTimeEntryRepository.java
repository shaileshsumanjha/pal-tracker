package io.pivotal.pal.tracker;

import java.util.*;


public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> listTimeEntries = new HashMap<Long, TimeEntry>();

    private TimeEntry timeEntry;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = listTimeEntries.size() + 1L;
        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        listTimeEntries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return listTimeEntries.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        listTimeEntries.replace(id, updatedEntry);
        return updatedEntry;
    }

    @Override
    public void delete(long id) {
        listTimeEntries.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(listTimeEntries.values());
    }
}
