package net.vanvendeloo.collections.comics;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComicRepository extends MongoRepository<Comic, String> {}
