import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import { Characters } from "../model/characters";
import { CharacterDetails } from "../model/character-details";
import { CharacterForm } from "../model/character-form";

/**
 * Character management service. Calls REST endpoints.
 */
@Injectable()
export class CharacterService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all characters.
   *
   * @return list of characters
   */
  getCharacters(): Observable<Characters> {
    return this.http.get<Characters>('/api/characters').pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Fetches single characters.
   *
   * @param uuid character's id
   * @return single characters
   */
  getCharacter(uuid: string): Observable<CharacterDetails> {
    return this.http.get<CharacterDetails>('/api/characters/' + uuid).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Removes single character.
   *
   * @param uuid character's id
   */
  deleteCharacter(uuid: string): Observable<any> {
    return this.http.delete('/api/characters/' + uuid).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Updates single character.
   *
   * @param uuid character's id
   * @param request request body
   */
  putCharacter(uuid: string, request: CharacterForm): Observable<any> {
    return this.http.put('/api/characters/' + uuid, request).pipe(
      catchError(this.handleError)
    );
  }
  private handleError(error: HttpErrorResponse) {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }


}
