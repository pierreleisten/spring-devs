/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.elasticsearch;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleElasticsearchApplication implements CommandLineRunner {

	@Autowired
	private ShazamEsRepository repository;

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();
		saveDocuments();
		fetchAllDocuments();
		fetchIndividualDocuments();
	}

	private void saveDocuments() {
		this.repository.save(new ShazamEsDocument("DOC-1", "Title for document 1",
				Arrays.asList("1#Signature|doc-1", "2#Another signature|doc-1", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-2", "Title for document 2",
				Arrays.asList("1#Signature|doc-2", "2#Another signature|doc-2", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-3", "Title for document 3",
				Arrays.asList("1#Signature|doc-3", "2#Another signature|doc-3", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-4", "Title for document 4",
				Arrays.asList("1#Signature|doc-4", "2#Another signature|doc-4", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-5", "Title for document 5",
				Arrays.asList("1#Signature|doc-5", "2#Another signature|doc-5", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-6", "Title for document 6",
				Arrays.asList("1#Signature|doc-6", "2#Another signature|doc-6", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-7", "Title for document 7",
				Arrays.asList("1#Signature|doc-7", "2#Another signature|doc-7", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-8", "Title for document 8",
				Arrays.asList("1#Signature|doc-8", "2#Another signature|doc-8", "3#Same signature for all docs")));
		this.repository.save(new ShazamEsDocument("DOC-9", "Title for document 9",
				Arrays.asList("1#Signature|doc-9", "2#Another signature|doc-9", "3#Same signature for all docs")));
	}

	private void fetchAllDocuments() {
		
		System.out.println("Documents found with findAll():");
		System.out.println("-------------------------------");
		
		this.repository.findAll().forEach(System.out::println);
		
		System.out.println();
		
	}

	private void fetchIndividualDocuments() {
		
		System.out.println("Documents found with findById('DOC-8'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findById("DOC-8"));

		System.out.println("Documents found with findBySignature('2#Another signature|doc-9'):");
		System.out.println("--------------------------------");
		this.repository.findBySignature("2#Another signature|doc-9").forEach(System.out::println);
		
		System.out.println("Documents found with findBySignature('3#Same signature for all docs'):");
		System.out.println("--------------------------------");
		this.repository.findBySignature("3#Same signature for all docs").forEach(System.out::println);
		
		System.out.println("Documents found with findBySignatureLike('1#Signature|doc-'):");
		System.out.println("--------------------------------");
		this.repository.findBySignatureLike("1#Signature|doc-").forEach(System.out::println);
		
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleElasticsearchApplication.class, "--debug").close();
	}

}
