import { User } from "../site/User/User";

export interface Slot{
    id: number;
    date: Date;
    hospitalname: string;
    time: string;
    user_id: number;
}