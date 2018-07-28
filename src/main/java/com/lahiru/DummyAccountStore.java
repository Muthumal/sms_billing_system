package com.lahiru;

public class DummyAccountStore implements AcountStore {
    @Override
    public Repository buildRepository() {
        Repository repository=new InMemoryRepository();
        repository.add(716484641,new PersonalAccount());
        Account account=new CorporateAccount();
        repository.add(716484642,account);
        repository.add(716484643,account);
        repository.add(716484644,account);
        repository.add(716484645,account);
        repository.add(716484646,account);

        return repository;
    }
}
