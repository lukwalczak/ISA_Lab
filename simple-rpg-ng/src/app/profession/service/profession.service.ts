import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Professions } from "../model/professions";
import { Profession } from "../model/profession";
import { ProfessionDetails } from "../model/profession-details";
import {ProfessionForm} from "../model/profession-form";

/**
 * Profession management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class ProfessionService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all professions.
   *
   * @return list of professions
   */
  getProfessions(): Observable<Professions> {
    return this.http.get<Professions>('/api/professions');
  }

  getProfession(uuid: string): Observable<ProfessionDetails> {
    return this.http.get<ProfessionDetails>('/api/professions/' + uuid);
  }

  deleteProfession(uuid: string): Observable<any> {
    return this.http.delete('/api/professions/' + uuid);
  }

  createProfession(request: ProfessionForm): Observable<any> {
    return this.http.post('/api/professions/', request);
  }

  putProfession(uuid: string, request: ProfessionForm): Observable<any> {
    return this.http.put('/api/professions/' + uuid, request);
  }

}
