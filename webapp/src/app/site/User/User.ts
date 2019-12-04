import { Blood } from "src/app/blood/Blood";
import { Role } from "src/app/blood/Role";
import { Experience } from "src/app/blood/Experience";

export interface User {
    id: number;
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    age: number;
    bloodgroup: string;
    gender: string;
    weight: number;
    contact: number;
    state: string;
    area: string;
    pincode: number;
    bloodrequireList: Blood[];
    roleList: Role[];
    experienceList: Experience[];
}
